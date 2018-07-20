package com.fate.zillusion.fgohelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class FragmentCraftEssence extends android.support.v4.app.Fragment {
    //region Valueables
    String[] itemname ={
            "マシュ・キリエライト","アルトリア・ペンドラゴン","アルトリア・ペンドラゴン［オルタ］","アルトリア・ペンドラゴン［リリィ］","ネロ・クラウディウス","ジークフリート","ガイウス・ユリウス・カエサル","アルテラ","ジル・ド・レェ","シュヴァリエ・デオン",
            "エミヤ","ギルガメッシュ","ロビンフッド","アタランテ","エウリュアレ","アーラシュ","アンリマユ","エリザベート・バートリー","武蔵坊弁慶","クー・フーリン〔プロトタイプ〕",
    };
    String[] itemdes ={
            "Mashu Kyrielight","Artoria Pendragon","Artoria Pendragon","Artoria Pendragon","Nero Claudius ","Siegfried","Gaius Julius Caesar","Attila","Gilles de Rais (Saber)","Chevalier d'Eon",
            "EMIYA","Gilgamesh","Robin Hood","Atalanta","Euryale","Arash","Angra Mainyu","Elizabeth Bathory","Musashibou Benkei","Cu Chulainn (Prototype)",
    };

    Integer[] imgid={
            R.drawable.s001,R.drawable.s002,R.drawable.s003,R.drawable.s004,R.drawable.s005,R.drawable.s006,R.drawable.s007,R.drawable.s008,R.drawable.s009,R.drawable.s010,
            R.drawable.s011,R.drawable.s012,R.drawable.s013,R.drawable.s014,R.drawable.s015,R.drawable.s016,R.drawable.s107,R.drawable.s018,R.drawable.s019,R.drawable.s020
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

    public FragmentCraftEssence() {
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_craft_essence, container, false);//Change

        //region ListView

        ListView listView=(ListView) view.findViewById(R.id.listview1);
        //CustomListAdapter adapter=new CustomListAdapter(getActivity(), itemname, imgid,itemdes);
        CustomListAdapter adapter=new CustomListAdapter(getActivity(), itemdes, imgid,itemname);
        listView.setAdapter(adapter);
        //Click_ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();//Inner
                //Toast.makeText(getActivity(),String.valueOf(+position),Toast.LENGTH_SHORT).show();//Display position

                //region 傳值

                Intent intent=new Intent();
                intent.setClass(getActivity(),Servant_Query_Activity_Net.class);
                Bundle bundle = new Bundle();
                bundle.putString("BundleServent",String.valueOf(+position));
                intent.putExtras(bundle);
                startActivity(intent);

                //endregion
            }
        });

        //endregion

        //region Fragment ListView
        /*
        ListView listView = (ListView) view.findViewById(R.id.listview);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<itemname.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt0",  itemname[i]);
            hm.put("txt1",  itemdes[i]);
            hm.put("img", Integer.toString(imgid[i]) );
            aList.add(hm);
        }
        // Keys used in Hashmap
        String[] from = { "img","txt0","txt1" };
        // Ids of views in listview_layout
        int[] to = { R.id.icon,R.id.item,R.id.item1};
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.mylist, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();//Inner
                Toast.makeText(getActivity(),String.valueOf(+position),Toast.LENGTH_SHORT).show();//Display position

            }
        });
*/
        //endregion

        //region ViewTitle
        if (mListener != null) {
            mListener.onFragmentInteraction( "Craft Essence");
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