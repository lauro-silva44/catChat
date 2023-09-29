package com.hfad.catchat

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar)

        //finds the nav host fragment by its ID
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment;
        //get the controller responsible for the destination pr paths
        val navController = navHostFragment.navController;
        //builds a configuration linking the toolbar to the navigation graph
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout);
        val builder = AppBarConfiguration.Builder(navController.graph);
        builder.setOpenableLayout(drawerLayout);
        val appBarConfiguration = builder.build();
        toolbar.setupWithNavController(navController, appBarConfiguration);
        val navView = findViewById<NavigationView>(R.id.nav_view);
        NavigationUI.setupWithNavController(navView, navController);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)

        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}