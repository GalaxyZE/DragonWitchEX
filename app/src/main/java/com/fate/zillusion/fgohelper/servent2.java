package com.fate.zillusion.fgohelper;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.fate.zillusion.fgohelper.FGO_RelateData.*;


public class servent2 extends Fragment {
    //region Valueables

        private String [] itemname;
        private Integer [] imgid;

    //endregion
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public servent2() {
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String str;
        SharedPreferences settings;
        settings = getActivity().getSharedPreferences("Data",0);
        str=settings.getString("SetLanguage","0");
        if (Integer.parseInt(str) == 1)
        {
            itemname=itemname_Chinese;
        }
        else if (Integer.parseInt(str) == 2)
        {
            itemname=itemname_China;
        }
        else
        {
            itemname=itemname_EN;
        }
        imgid=Data_Servent_imgid;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_servent2, container, false);//Change

        //region Adview
        MobileAds.initialize(getActivity(), "ca-app-pub-8418426477328402~2027922183");
        AdView mAdView = (AdView) view.findViewById(R.id.adview_servent2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //endregion

        //region Fragment ListView

        final ListView listView = (ListView) view.findViewById(R.id.listview);
        // Each row in the list stores country name, currency and flag
        final List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        final List<HashMap<String,String>> comparelist=new ArrayList<HashMap<String,String>>();

        for(int i=itemname.length-1;i>=0;i--){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt0",  itemname[i]);
            hm.put("txt1",  itemdes[i]);
            hm.put("img", Integer.toString(imgid[i]) );
            aList.add(hm);
            //---------------
            comparelist.add(hm);
        }
        // Keys used in Hashmap
        final String[] from = { "img","txt0","txt1" };
        // Ids of views in listview_layout
        final int[] to = { R.id.icon,R.id.item,R.id.item1};
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
         final SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.mylist, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @SuppressLint("NewApi")
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                int Bpos=itemname.length-1-(+position);
                Intent intent=new Intent();
    //            intent.setClass(getActivity(),Servent_Query_Activity.class);
                intent.setClass(getActivity(),Servent_Query_Activity_Net.class);
                Bundle bundle = new Bundle();
                //region Judge
                for (int i=0;i<itemname.length;i++)
                {
                    if (adapter.getItem(+position) ==(comparelist.get(itemname.length-1-i)))
                    {
                        bundle.putString("BundleServent",String.valueOf(i));
                        intent.putExtras(bundle);
                        Toast.makeText(getActivity(),"No."+String.valueOf(i+1),Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                 startActivity(intent);



                //endregion

                //Toast.makeText(getActivity(),result,Toast.LENGTH_SHORT).show();//Display position
                //Toast.makeText(getActivity(),String.valueOf(Bpos),Toast.LENGTH_SHORT).show();//Display position

            }
        });

        //endregion

        //region Search View
        final SearchView sv=(SearchView) view.findViewById(R.id.Serach_Servent);
        sv.setQueryHint("Servent Name");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                //Toast.makeText(getActivity(),newText,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //endregion

        //region Floating Action Button
        FloatingActionButton fab = view.findViewById(R.id.fab);
        if (fab!=null)
        {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //region AlertDialog
                    final View item = LayoutInflater.from(getActivity()).inflate(R.layout.classalterdialog_layout, null);
                    new AlertDialog.Builder(getActivity())
                            .setTitle(R.string.ClassDialogShowTitle)
                            .setView(item)

                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Toast.makeText(getActivity(),"OK",Toast.LENGTH_SHORT).show();
                                    CheckBox saber = (CheckBox) item.findViewById(R.id.checkbox_Saber);
                                    CheckBox archer = (CheckBox) item.findViewById(R.id.checkbox_Archer);
                                    CheckBox lancer = (CheckBox) item.findViewById(R.id.checkbox_Lancer);
                                    CheckBox rider = (CheckBox) item.findViewById(R.id.checkbox_Rider);
                                    CheckBox caster = (CheckBox) item.findViewById(R.id.checkbox_Caster);
                                    CheckBox assassin = (CheckBox) item.findViewById(R.id.checkbox_Assassin);
                                    CheckBox berserker = (CheckBox) item.findViewById(R.id.checkbox_Berserker);
                                    CheckBox other = (CheckBox) item.findViewById(R.id.checkbox_Other);

                                    CheckBox star5 = (CheckBox) item.findViewById(R.id.Star5);
                                    CheckBox star4 = (CheckBox) item.findViewById(R.id.Star4);
                                    CheckBox star3 = (CheckBox) item.findViewById(R.id.Star3);
                                    CheckBox star2 = (CheckBox) item.findViewById(R.id.Star2);
                                    CheckBox star1 = (CheckBox) item.findViewById(R.id.Star1);

                                    //textid_Servent_Status[GetValue][2] class
                                    //Integer.parseInt(textid_Servent_Status[GetValue][1] star

                                    //region if-else

                                     aList.clear();
                                     comparelist.clear();

                                    //region 單一職階選擇
                                    if (saber.isChecked() && !archer.isChecked() && !lancer.isChecked() && !rider.isChecked() && !caster .isChecked() && !assassin.isChecked() && !berserker.isChecked() && !other.isChecked() )
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2]=="1")
                                             {
                                                 //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && archer.isChecked() && !lancer.isChecked() && !rider.isChecked() && !caster .isChecked() && !assassin.isChecked() && !berserker.isChecked() && !other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2] == "2") {
                                                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && !archer.isChecked() && lancer.isChecked() && !rider.isChecked() && !caster .isChecked() && !assassin.isChecked() && !berserker.isChecked() && !other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2] == "3") {
                                                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && !archer.isChecked() && !lancer.isChecked() && rider.isChecked() && !caster .isChecked() && !assassin.isChecked() && !berserker.isChecked() && !other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2] == "4") {
                                                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && !archer.isChecked() && !lancer.isChecked() && !rider.isChecked() && caster .isChecked() && !assassin.isChecked() && !berserker.isChecked() && !other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2] == "5") {
                                                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && !archer.isChecked() && !lancer.isChecked() && !rider.isChecked() && !caster .isChecked() && assassin.isChecked() && !berserker.isChecked() && !other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2] == "6") {
                                                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && !archer.isChecked() && !lancer.isChecked() && !rider.isChecked() && !caster .isChecked() && !assassin.isChecked() && berserker.isChecked() && !other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++)
                                        {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);

                                            if (textid_Servent_Status[i][2] == "7") {
                                                //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                aList.add(hm);
                                            }
                                        }
                                    }
                                    else if (!saber.isChecked() && !archer.isChecked() && !lancer.isChecked() && !rider.isChecked() && !caster .isChecked() && !assassin.isChecked() && !berserker.isChecked() && other.isChecked())
                                    {
                                        for (int i=0;i<itemname.length;i++) {
                                            HashMap<String, String> hm = new HashMap<String, String>();
                                            hm.put("txt0", itemname[i]);
                                            hm.put("txt1", itemdes[i]);
                                            hm.put("img", Integer.toString(imgid[i]));
                                            comparelist.add(hm);
                                            if (textid_Servent_Status[i][2] != "?")
                                            {
                                                if (Integer.parseInt(textid_Servent_Status[i][2]) > 7 && Integer.parseInt(textid_Servent_Status[i][2]) <= 14 ) {

                                                    //Toast.makeText(getActivity(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                                                    aList.add(hm);
                                                }
                                            }
                                        }
                                    }
                                    //endregion

                                    //region 2種職階選擇

                                    //endregion

                                    //endregion

                                    //region listview OnClick
                                   final SimpleAdapter adapter = new SimpleAdapter(getActivity(), aList, R.layout.mylist, from, to);
                                    listView.setAdapter(adapter);
                                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                            Intent intent=new Intent();
                                            //intent.setClass(getActivity(),Servent_Query_Activity.class);
                                            intent.setClass(getActivity(),Servent_Query_Activity_Net.class);
                                            Bundle bundle = new Bundle();

                                            for (int i=0;i<itemname.length;i++)
                                            {
                                                if (adapter.getItem(+position) ==(comparelist.get(i)))
                                                {
                                                    bundle.putString("BundleServent",String.valueOf(i));
                                                    intent.putExtras(bundle);
                                                    Toast.makeText(getActivity(),"No."+String.valueOf(i+1),Toast.LENGTH_SHORT).show();
                                                    break;
                                                }
                                            }
                                            startActivity(intent);
                                        }
                                    });
                                    //endregion
                                    sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                        @Override
                                        public boolean onQueryTextSubmit(String query) {

                                            return false;
                                        }

                                        @Override
                                        public boolean onQueryTextChange(String newText) {
                                            adapter.getFilter().filter(newText);
                                            return false;
                                        }
                                    });
                                }
                            })


                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })

                            .show();

                    //endregion
                }
            });
        }
        //endregion




        //region ViewTitle
        if (mListener != null) {
            mListener.onFragmentInteraction( "Servent");
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

    @Override
    public void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);

    }

    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }

    public static ProgressDialog showProgressDialog(Context context, String message)  {
        ProgressDialog m_Dialog = new ProgressDialog(context);
        m_Dialog.setMessage(message);
        m_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        m_Dialog.setTitle("Please Wait");
        m_Dialog.setCancelable(true);
        m_Dialog.show();
        return m_Dialog;
    }





}
