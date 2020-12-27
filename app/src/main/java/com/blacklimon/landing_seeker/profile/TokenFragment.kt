package com.blacklimon.landing_seeker.profile

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.blacklimon.landing_seeker.R
import com.blacklimon.landing_seeker.databinding.FragmentTokenBinding
import com.blacklimon.landing_seeker.utils.PreferenceUtility
import com.blacklimon.landing_seeker.utils.Keys

class TokenFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentTokenBinding?= null
    private val binding get() = _binding!!
    private lateinit var navController:NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTokenBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        redirectToHome(context)
        context?.let { PreferenceUtility.setBoolean(it,Keys.SharedPreferenceKeys.FIRST_INITIALIZATION,true) }
        binding.tvSkip.setOnClickListener(this)
        binding.ibForward.setOnClickListener(this)

        binding.etToken.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(s!!.isNotEmpty())
                    binding.tilToken.error = ""

            }
        })

    }

    private fun  redirectToHome(ctx: Context?) {
        if(ctx != null ){
            if(PreferenceUtility.getBoolean(ctx,Keys.SharedPreferenceKeys.FIRST_INITIALIZATION))
                navigateToHomeFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.tvSkip.id -> {
                navigateToHomeFragment()
            }
            binding.ibForward.id -> {
                checkTokenAndNavigate()
            }
        }
    }

    private fun navigateToHomeFragment(){
        navController!!.navigate(R.id.action_tokenFragment_to_homeFragment2)
    }


    private fun checkTokenAndNavigate(){
        val token:String = binding.etToken.text.toString()

        if(token.isEmpty()){
            binding.tilToken.error = getString(R.string.noTokenError)
        }else{
            context?.let { PreferenceUtility.setString(it,Keys.SharedPreferenceKeys.TOKEN,token) }
            navigateToHomeFragment()
        }

    }
}