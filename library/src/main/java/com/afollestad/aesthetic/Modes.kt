/*
 * Licensed under Apache-2.0
 *
 * Designed and developed by Aidan Follestad (@afollestad)
 */
package com.afollestad.aesthetic

/** @author Aidan Follestad (afollestad)*/
enum class TabLayoutBgMode(val value: Int) {
  PRIMARY(0),
  ACCENT(1);

  companion object {
    fun fromInt(value: Int): TabLayoutBgMode {
      return when (value) {
        0 -> PRIMARY
        else -> ACCENT
      }
    }
  }
}

/** @author Aidan Follestad (afollestad) */
enum class NavigationViewMode(val value: Int) {
  SELECTED_PRIMARY(0),
  SELECTED_ACCENT(1);

  companion object {
    fun fromInt(value: Int): NavigationViewMode {
      return when (value) {
        0 -> SELECTED_PRIMARY
        else -> SELECTED_ACCENT
      }
    }
  }
}

/** @author Aidan Follestad (afollestad) */
enum class AutoSwitchMode(val value: Int) {
  OFF(0),
  ON(1),
  AUTO(2);

  companion object {
    fun fromInt(value: Int): AutoSwitchMode {
      return when (value) {
        0 -> OFF
        1 -> ON
        else -> AUTO
      }
    }
  }
}

/** @author Aidan Follestad (afollestad) */
enum class BottomNavBgMode(val value: Int) {
  BLACK_WHITE_AUTO(0),
  PRIMARY(1),
  PRIMARY_DARK(2),
  ACCENT(3);

  companion object {
    fun fromInt(value: Int): BottomNavBgMode {
      return when (value) {
        0 -> BLACK_WHITE_AUTO
        1 -> PRIMARY
        2 -> PRIMARY_DARK
        else -> ACCENT
      }
    }
  }
}

/** @author Aidan Follestad (afollestad) */
enum class TabLayoutIndicatorMode(val value: Int) {
  PRIMARY(0),
  ACCENT(1);

  companion object {
    fun fromInt(value: Int): TabLayoutIndicatorMode {
      return when (value) {
        0 -> PRIMARY
        else -> ACCENT
      }
    }
  }
}

/** @author Aidan Follestad (afollestad) */
enum class BottomNavIconTextMode(val value: Int) {
  SELECTED_PRIMARY(0),
  SELECTED_ACCENT(1),
  BLACK_WHITE_AUTO(2);

  companion object {
    fun fromInt(value: Int): BottomNavIconTextMode {
      return when (value) {
        0 -> SELECTED_PRIMARY
        1 -> SELECTED_ACCENT
        else -> BLACK_WHITE_AUTO
      }
    }
  }
}
