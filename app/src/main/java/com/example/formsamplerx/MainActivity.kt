package com.example.formsamplerx

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.formsamplerx.databinding.ActivityMainBinding
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    val properties = FormProperties()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.activity = this

        compositeDisposable.add(properties.getValidationObservable())
     }


    fun onGenderClicked() {
        val items = arrayOf("男性", "女性")
        AlertDialog.Builder(this)
            .setTitle("性別を選択してください")
            .setItems(items, { _, which -> properties.isMan = (which == 0) })
            .show()
    }

    fun onBirthdayClicked() {
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener({ _, y, m, d -> properties.birthday = Calendar.getInstance().apply { set(y, m, d) } }),
            2000, 0, 1).show()
    }

    fun register() {
        startActivity(RegistrationCompleteActivity.createIntent(this))
        finish()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
