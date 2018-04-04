package com.example.zillusion.fgohelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.zillusion.fgohelper.FGO_RelateData.eventimgid;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_Event.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_Event#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_Event extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fragment_Event() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Event.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_Event newInstance(String param1, String param2) {
        fragment_Event fragment = new fragment_Event();
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
        View view=inflater.inflate(R.layout.fragment_event, container, false);
        //region Fragment ListView

        ListView listView = (ListView) view.findViewById(R.id.listview_fragment_Event);
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
        if (mListener != null) {
            mListener.onFragmentInteraction( "Event");
        }
        return view;
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
