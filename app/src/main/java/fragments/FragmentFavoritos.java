package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ben.nicestart2.R;


public class FragmentFavoritos extends Fragment {

    public FragmentFavoritos() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentFavoritos newInstance(String param1, String param2) {
        FragmentFavoritos fragment = new FragmentFavoritos();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false);
    }
}