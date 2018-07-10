package com.fate.zillusion.fgohelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Quest.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Quest#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quest extends Fragment {
    //region Value Define

    private View private_view;
    private String TAG="Fragment_Quset";

    private Integer []img_mission={//Img Mission List
            R.drawable.m08,R.drawable.m07,R.drawable.m06,R.drawable.m05,R.drawable.m04,R.drawable.m03,R.drawable.m02,R.drawable.m01,R.drawable.m00,

    };

    private String [] str_Clickmission={""};


    //endregion


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Quest() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Quest.
     */
    // TODO: Rename and change types and number of parameters
    public static Quest newInstance(String param1, String param2) {
        Quest fragment = new Quest();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_quest, container, false);
        private_view=view;

        //region Adview
        MobileAds.initialize(getActivity(), "ca-app-pub-8418426477328402~2027922183");
        AdView mAdView = (AdView) view.findViewById(R.id.adview_quest);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //endregion

        //region Fragment ListView

        ListView listView = (ListView) view.findViewById(R.id.listview_quest);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<img_mission.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("img", Integer.toString(img_mission[i]) );
            aList.add(hm);
        }
        String[] from = {"img"};
        int[] to = { R.id.newsimageView};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.imagelistviewlayout1, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(),"This feature has not been completed", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(),String.valueOf(position), Toast.LENGTH_SHORT).show();//Display position
                //region 傳值
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), Activity_Query_Quest.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("BundleQuest", String.valueOf(+position));
                    intent.putExtras(bundle);
                    startActivity(intent);

                //endregion

            }
        });

        //endregion







        //region return view
        if (mListener != null) {
            mListener.onFragmentInteraction( "Quset");
        }
        return view;
        //endregion

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String title) {
        if (mListener != null) {
            mListener.onFragmentInteraction(title);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }


}
