package pndtech.com.istarve.view.cartContainer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pndtech.com.istarve.R;

public class CartContainerFragment extends Fragment {
    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_container_cart, container, false);
        View view =root.findViewById(R.id.nav_host_pay_fragment);
        navController = Navigation.findNavController(view);
        floatingActionButton = root.findViewById(R.id.next_float);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });

        return root;
    }



}
