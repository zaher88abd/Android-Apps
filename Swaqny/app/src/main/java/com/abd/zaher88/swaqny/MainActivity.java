package com.abd.zaher88.swaqny;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.abd.zaher88.swaqny.DataClasses.ListMaterialAdapter;
import com.abd.zaher88.swaqny.DataClasses.Material;

import java.util.List;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.DrawerLisner {
    Toolbar toolbar;
    private DrawerLayout mDrawLayout;
    RestClient restClient = new RestClient();
    RecyclerView matrialRecyclerView;
    String lan;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getApplicationContext();
            if (Locale.getDefault().getDisplayLanguage().equals("العربية"))
                lan = Constants.ArabicLanguge;
            else lan = Constants.EngLanguge;
            setContentView(R.layout.activity_main);
            setUpToolbar();
            setUpDrawer();
            getMatrialList();
        } catch (Exception ex) {
            Log.d("OnCreate", ex.getMessage());
        }
    }

    public void setUpMAtrialRecyclerView(List<Material> matrialList) {
        try {
            ListMaterialAdapter adapter = new ListMaterialAdapter(this, matrialList,
                    new ListMaterialAdapter.OnMatrialItemClickListener() {
                        @Override
                        public void onItemClick(Material item) {
                            Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();
                        }
                    });
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            matrialRecyclerView = (RecyclerView) findViewById(R.id.rcvMaterial);
            matrialRecyclerView.setAdapter(adapter);
            matrialRecyclerView.setLayoutManager(linearLayoutManager);
        } catch (Exception e) {
            Log.d("setUpMAtrialRecyclerView", e.getMessage());
        }
    }

    private void getMatrialList() {
        try {
            SawqniService service = restClient.getApiService();
            Call<Material> call = service.getFirstMaterals(Constants.UserService, Constants.PassService, lan);
            call.enqueue(new Callback<Material>() {
                @Override
                public void onResponse(Response<Material> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        Log.d("getMatrialList", "isSuccess");
                        List<Material> list = response.body().getGetFirstMateralsResult();
                        setUpMAtrialRecyclerView(response.body().getGetFirstMateralsResult());
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                }
            });
        } catch (Exception e) {
            Log.d("getMatrialList", e.getMessage());
        }
    }


    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private void setUpDrawer() {
        try {
            NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                    getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
        } catch (Exception e) {
            Log.d("main1_activity.setUpDrawer", e.getMessage());
        }
    }


    @Override
    public void setCatigoryMaterial(int Id) {
        try {
            getMatrialByCatigory(Id);
        } catch (Exception e) {
            Log.d("setCatigoryMaterial ", e.getMessage());
        }
    }

    private void getMatrialByCatigory(int id) {
        RestClient restClient = new RestClient();
        Call<Material> call = restClient.getApiService()
                .getAllMaterialsByCategoryId(Constants.UserService, Constants.PassService, lan, id);
        call.enqueue(new Callback<Material>() {
            @Override
            public void onResponse(Response<Material> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Toast.makeText(context,
                            String.valueOf(response.body().getGetAllMaterialsByCategoryIdResult().size()),
                            Toast.LENGTH_SHORT).show();
                    setUpMAtrialRecyclerView(response.body().getGetAllMaterialsByCategoryIdResult());
                } else {
                    Log.d("getMatrialByCatigory", "Failure");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("getMatrialByCatigory", "onFailure");
            }
        });
    }


}
