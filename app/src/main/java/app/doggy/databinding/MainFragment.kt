package app.doggy.databinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import app.doggy.databinding.databinding.FragmentMainBinding
import app.doggy.databinding.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        //LiveDataが，値の更新を検知できるようにする．
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isEnabled.observe(viewLifecycleOwner, Observer { isEnabled ->
            binding.displayButton.isEnabled = isEnabled
        })

        binding.inputEditText.addTextChangedListener { text ->
            viewModel.changeDisplayButtonState(text.isNullOrBlank())
        }

        binding.displayButton.setOnClickListener {
            viewModel.displayText(binding.inputEditText.text.toString())
        }
    }
}