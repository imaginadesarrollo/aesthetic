/*
 * Licensed under Apache-2.0
 *
 * Designed and developed by Aidan Follestad (@afollestad)
 */
package com.afollestad.aesthetic

import android.content.Context
import android.support.v7.widget.AppCompatImageButton
import android.util.AttributeSet
import com.afollestad.aesthetic.actions.ImageViewTintAction
import com.afollestad.aesthetic.actions.ViewBackgroundAction
import com.afollestad.aesthetic.utils.ViewUtil.getObservableForResId
import com.afollestad.aesthetic.utils.distinctToMainThread
import com.afollestad.aesthetic.utils.onErrorLogAndRethrow
import com.afollestad.aesthetic.utils.plusAssign
import com.afollestad.aesthetic.utils.resId
import io.reactivex.disposables.CompositeDisposable

/** @author Aidan Follestad (afollestad) */
class AestheticImageButton(
  context: Context,
  attrs: AttributeSet? = null
) : AppCompatImageButton(context, attrs) {

  private var subs: CompositeDisposable? = null
  private var backgroundResId: Int = 0
  private var tintResId: Int = 0

  init {
    if (attrs != null) {
      backgroundResId = context.resId(attrs, android.R.attr.background)
      tintResId = context.resId(attrs, R.attr.tint)
      if (tintResId == 0) {
        tintResId = context.resId(attrs, android.R.attr.tint)
      }
    }
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    subs = CompositeDisposable()

    val backgroundObs = getObservableForResId(context, backgroundResId, null)
    if (backgroundObs != null) {
      subs!! += backgroundObs
          .distinctToMainThread()
          .subscribe(
              ViewBackgroundAction(this),
              onErrorLogAndRethrow()
          )
    }

    val tintObs = getObservableForResId(context, tintResId, null)
    if (tintObs != null) {
      subs!! += tintObs
          .distinctToMainThread()
          .subscribe(
              ImageViewTintAction(this),
              onErrorLogAndRethrow()
          )
    }
  }

  override fun onDetachedFromWindow() {
    subs?.dispose()
    super.onDetachedFromWindow()
  }
}
