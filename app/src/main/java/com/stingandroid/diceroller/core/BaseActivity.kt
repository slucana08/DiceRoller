package com.stingandroid.diceroller.core

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

@SuppressLint("Registered")
open class BaseActivity<T : ViewDataBinding?>(actions : ActivityActions) : AppCompatActivity() , ActivityActions by actions {

    protected var binding : T? = null
        get() = field ?: throw UninitializedPropertyAccessException("\"tmp\" was queried before being initialized")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<T>(this,getLayoutResId())
    }
}

