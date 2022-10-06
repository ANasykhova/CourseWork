package com.example.coursework;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapFragment extends Fragment {

    public MapFragment(){
        MapKitFactory.setApiKey("a6c9e2c0-63e8-49f8-b259-31e3de4806da");
    }

    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MapKitFactory.initialize(this.getActivity());
        View mainView = inflater.inflate(R.layout.map_fragment, null);
        mapView = mainView.findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(new Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
        mapView.onStart();
        return inflater.inflate(R.layout.map_fragment, container, false);
    }
}