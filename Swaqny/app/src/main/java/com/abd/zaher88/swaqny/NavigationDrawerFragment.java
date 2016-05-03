package com.abd.zaher88.swaqny;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abd.zaher88.swaqny.DataClasses.Category;
import com.abd.zaher88.swaqny.DataClasses.ListCategoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Zaher on 27/04/2016.
 */
public class NavigationDrawerFragment extends Fragment {
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private DrawerLisner drawerLisner;
    ViewGroup viewGroup;
    List<Category> list;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        drawerLisner=(DrawerLisner) ((Activity)context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View   view = inflater.inflate(R.layout.fragment_nav_drawer, container, false);
        viewGroup = container;
        getListCategory(view);
        Log.d("NavigationDrawerFragment","onCreateView");
        return view;
    }

    private void getListCategory(final View view) {
        list = new ArrayList<Category>();
        try {
            String lan;
            if (Locale.getDefault().getDisplayLanguage().equals("العربية"))
                lan=Constants.ArabicLanguge;
            else lan=Constants.EngLanguge;

            RestClient restClient=new RestClient();
            SawqniService service=restClient.getApiService();
            Call<Category> call=service.getParentsMateralsCategoriesResult(Constants.UserService,Constants.PassService,lan);
            call.enqueue(new Callback<Category>() {
                @Override
                public void onResponse(Response<Category> response, Retrofit retrofit) {
                    if(response.isSuccess())
                    {
                        Log.d("getAllMaterialsCategories","isSuccess");
                        Category c=response.body();
                        list=response.body().GetParentsMateralsCategoriesResult();
                        setUpRecyclerView(view, list);
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("getAllMaterialsCategories","onFailure :"+t.getMessage());
                }
            });
        } catch (Exception ex) {
            Log.d("getListCategory", ex.getMessage());
        }

    }

    private void setUpRecyclerView(View view, List<Category> listCategory) {
        try{
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcvCategory);
        ListCategoryAdapter adapter = new ListCategoryAdapter(getActivity(), listCategory,
                new ListCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Category item) {
                drawerLisner.setCatigoryMaterial(item.getId());

                Log.d("asdas", "asdas");
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }catch (Exception e)
        {
            Log.d("setUpRecyclerView",e.getMessage());
        }
    }

    public void setUpDrawer(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // Do something of Slide of Drawer
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public interface DrawerLisner {
        public void setCatigoryMaterial(int Id);
    }
}
