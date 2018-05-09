package com.fate.zillusion.fgohelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


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

    private String [][] str_Quest={
            {
              "「炎上汚染都市：冬木」","第一節：燃える街","進行度1","第二節：霊脈地へ","進行度1","第三節：大橋を調べる","進行度1","進行度2","進行度3",
              "第四節：港跡を調べる","進行度1","進行度2","第五節：教会跡を調べる","進行度1","進行度2","第六節：影のサーヴァント",
              "進行度1","進行度2","進行度3","第七節：大聖杯を目指せ","進行度1","進行度2","第八節：マシュの特訓","進行度1",
              "進行度2","進行度3","進行度4","進行度5","第九節：暗がりの洞窟","進行度1","進行度2","進行度3","第十節：大聖杯目前",
              "進行度1","進行度2","進行度3","第十一節：グランドオーダー","進行度1"
            },//0
    };
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
