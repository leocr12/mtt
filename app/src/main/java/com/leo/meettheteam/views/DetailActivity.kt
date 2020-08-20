package com.leo.meettheteam.views

import android.os.Bundle
import android.view.MenuItem
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import com.leo.meettheteam.R
import com.leo.meettheteam.databinding.ActivityDetailBinding
import com.leo.meettheteam.models.User


class DetailActivity : AppCompatActivity() {

    lateinit var user: User
    private val showPersonality = ObservableBoolean(false)
    private val showInterest = ObservableBoolean(false)
    private val showDating = ObservableBoolean(false)

    companion object {
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        title = getString(R.string.detail_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras

        extras?.let {
            user = it.get(USER) as User
        }

        initView(binding)
        initListeners(binding)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initView(binding: ActivityDetailBinding) {
        binding.user = user
        binding.showPersonality = showPersonality
        binding.showInterest = showInterest
        binding.showDating = showDating
    }

    private fun initListeners(binding: ActivityDetailBinding) {
        binding.userPersonalityContainer.setOnClickListener {
            showPersonality.set(!showPersonality.get())
            rotateChevron(showPersonality, binding.personalityChevron)
        }

        binding.userInterestContainer.setOnClickListener {
            showInterest.set(!showInterest.get())
            rotateChevron(showInterest, binding.interestChevron)
        }

        binding.userDatingContainer.setOnClickListener {
            showDating.set(!showDating.get())
            rotateChevron(showDating, binding.datingChevron)
        }
    }

    private fun rotateChevron(show: ObservableBoolean, view: ImageView) {
        val animSet = AnimationSet(true)
        animSet.interpolator = DecelerateInterpolator()
        animSet.fillAfter = true
        animSet.isFillEnabled = true

        val fromRotation = if (show.get()) 0.0f else -180.0f
        val toRotation = if (show.get()) -180.0f else 0.0f
        val animRotate = RotateAnimation(
            fromRotation, toRotation,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        animRotate.duration = 500
        animRotate.fillAfter = true
        animSet.addAnimation(animRotate)

        view.startAnimation(animSet)
    }
}