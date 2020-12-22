package com.mybills.info.dialogs

interface DialogListener {
  fun   onPositiveButtonClick(actionType : String)
  fun   onNegativeButtonClick(actionType : String)
}