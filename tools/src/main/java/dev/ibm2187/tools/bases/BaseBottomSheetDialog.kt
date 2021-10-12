package dev.ibm2187.tools.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialog<V : ViewBinding> : BottomSheetDialogFragment() {

    abstract val _ViewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> V

    private var _ViewBinding: V? = null
    val binding get() = _ViewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _ViewBinding = _ViewBindingInflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _ViewBinding = null
        dialog?.setOnDismissListener(null)
        dialog?.setOnCancelListener(null)
    }

}