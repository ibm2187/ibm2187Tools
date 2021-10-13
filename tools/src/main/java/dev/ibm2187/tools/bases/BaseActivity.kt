package dev.ibm2187.tools.bases

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract val _ViewBindingInflater: (LayoutInflater) -> VB
    val binding by lazy { _ViewBindingInflater(layoutInflater) }

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    fun initNavController(fragmentContainerView: FragmentContainerView) {
        supportFragmentManager.findFragmentById(fragmentContainerView.id)
            ?.apply {
                navController = this.findNavController()
            }
    }

    open fun initToolbar(toolbar: Toolbar) {

        setSupportActionBar(toolbar)

        setupNavGraph()

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    open fun setupNavGraph(customNavGraph: NavGraph? = null) {
        appBarConfiguration = AppBarConfiguration(customNavGraph ?: navController.graph)
    }

}