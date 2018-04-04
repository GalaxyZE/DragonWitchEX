package com.example.zillusion.fgohelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.example.zillusion.fgohelper.FGO_RelateData.eventimgid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class News extends Fragment {
    //region Values




    //endregion
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public News() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static News newInstance(String param1, String param2) {
        News fragment = new News();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_news, container, false);

        //region Fragment ListView

        ListView listView = (ListView) view.findViewById(R.id.newslistview);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=eventimgid.length-1;i>132;i--){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("img", Integer.toString(eventimgid[i]) );
            aList.add(hm);
        }
        String[] from = {"img"};
        int[] to = { R.id.newsimageView};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.imagelistviewlayout, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();//Inner
                Toast.makeText(getActivity(),String.valueOf(+position), Toast.LENGTH_SHORT).show();//Display position

                //region 傳值
                if (+position!=17)
                {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), EventDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("BundleNews", String.valueOf(+position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), OldNewsActivity.class);
                    startActivity(intent);
                }
                //endregion

            }
        });

        //endregion

        //region return view
        if (mListener != null) {
            mListener.onFragmentInteraction( "News");
        }
        return view;
        //endregion
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

    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }

}
