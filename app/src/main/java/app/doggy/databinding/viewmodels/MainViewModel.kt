package app.doggy.databinding.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel {

    //display_textのtext
    private val _displayText =
        MutableLiveData<String>().also { mutableLiveData ->
            mutableLiveData.value = "Displayed here."
        }
    val displayText: LiveData<String>
        get() = _displayText

    //set_buttonが押せるか否か
    private val _isEnabled: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().also { mutableLiveData ->
            mutableLiveData.value = false
        }
    val isEnabled: LiveData<Boolean>
        get() = _isEnabled

    //set_buttonのtext
    private val _displayButtonText: MutableLiveData<String> =
        MutableLiveData<String>().also { mutableLiveData ->
            mutableLiveData.value = "Ready"
        }
    val displayButtonText: LiveData<String>
        get() = _displayButtonText

    //display_buttonのtextを変更
    fun changeDisplayButtonState(isBlank: Boolean) {
        _isEnabled.value = !isBlank

        if (!isBlank) {
            _displayButtonText.value = "Display"
        } else {
            _displayButtonText.value = "Ready"
        }
    }

    //display_textにtextを表示
    fun displayText(text: String) {
        _displayText.value = text
    }

}