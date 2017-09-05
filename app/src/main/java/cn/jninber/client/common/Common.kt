package cn.jninber.client.common

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

/**
 * Created by jninber on 2017/7/5.
 * 基础的扩展存放
 *
 **/

fun Context.dip(value: Int): Int = this.resources.displayMetrics.density.times(value).toInt()

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toast(@StringRes res: Int) = Toast.makeText(this, res, Toast.LENGTH_SHORT).show()

fun Context.getWidthPixels(): Int = this.resources.displayMetrics.widthPixels

fun Context.getHeightPixels(): Int = this.resources.displayMetrics.heightPixels