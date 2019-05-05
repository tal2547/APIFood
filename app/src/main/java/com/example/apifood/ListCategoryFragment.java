package com.example.apifood;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListCategoryFragment extends Fragment {

    // Explicit
    private MyConstant myConstant = new MyConstant();

    public ListCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Create Re
        createRecyclerView();
    } // Main Meth

    private void createRecyclerView() {
        try {

            ReadCategoryThread readCategoryThread = new ReadCategoryThread(getActivity());
            readCategoryThread.execute("",myConstant.getUrlCategory());
            String response = readCategoryThread.get();
            Log.d("5Mayv1","reponse ==>" + response);

        } catch (Exception e) {
            Log.d("Smayv1","e at Fragmentlistcat ==>" + e.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_category, container, false);
    }

} // Main Class
