package com.fate.zillusion.fgohelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Eventguide.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Eventguide#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Eventguide extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String TAB="EventGuide";
    private View viewpravite=null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Eventguide() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Eventguide.
     */
    // TODO: Rename and change types and number of parameters
    public static Eventguide newInstance(String param1, String param2) {
        Eventguide fragment = new Eventguide();
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
        View view=inflater.inflate(R.layout.fragment_eventguide, container, false);
        viewpravite=view;

        new GetBitmapTask().execute("https://ms0266378.github.io/fgo.query/images/android/img_NowEvent.png");

        //region Adview
        MobileAds.initialize(getActivity(), "ca-app-pub-8418426477328402~2027922183");
        AdView mAdView = (AdView) view.findViewById(R.id.adview_eventguide);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //endregion

        //region Floating Action Button
        FloatingActionButton fabEG=view.findViewById(R.id.fab_eventguide);
        if (fabEG!=null)
        {
            fabEG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://goo.gl/paEJqz");
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(it);
                }
            });
        }
        //endregion

        //region ImageView Action
        final ImageView img_EventGuide=view.findViewById(R.id.img_eventguide);

        img_EventGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img_ActShow=new Intent();
                img_ActShow.setClass(getActivity(),img_Servent_Zoom.class);


                Bitmap bitmap=((BitmapDrawable)img_EventGuide.getDrawable()).getBitmap();
                if (createImageFromBitmap(bitmap)!=null)
                {
                    try {
                        startActivity(img_ActShow);
                    } catch (Exception e) {
                        String TAG = "---ImageView Button---";
                        Log.d(TAG, "onClick: " + e);
                    }
                }

            }
        });
        //endregion

        //region return view
        if (mListener != null) {
            mListener.onFragmentInteraction( "EventGuide");
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

    private class GetBitmapTask extends AsyncTask<String, Void, Bitmap> {
        // new MyAsyncTask().execute("URL");
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch(IOException e) {
                Log.d("DoInBackground",e.toString());
                return null;
            }
        }

        protected void onPostExecute(Bitmap result) {
            //do what you want with your bitmap result on the UI thread
            if (result!=null)
            {
                ImageView img=viewpravite.findViewById(R.id.img_eventguide);
                img.setImageBitmap(result);
            }
            result=null;



        }
    }

    public String createImageFromBitmap(Bitmap bitmap) {
        String fileName = "myImage";//no .png or .jpg needed
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            FileOutputStream fo = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            // remember close file output
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
            fileName = null;
        }
        return fileName;
    }


}
