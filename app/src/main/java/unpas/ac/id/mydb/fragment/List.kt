package unpas.ac.id.mydb.fragment

import android.os.Bundle
import android.os.Debug
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import unpas.ac.id.mydb.R
import unpas.ac.id.mydb.adapter.MahasiswaAdapter
import unpas.ac.id.mydb.data.Mahasiswa
import unpas.ac.id.mydb.databinding.FragmentListBinding
import unpas.ac.id.mydb.viewModel.MahasiswaViewModel

class List : Fragment() {
    lateinit var listBinding: FragmentListBinding
    lateinit var mahasiswaViewModel: MahasiswaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        listBinding = FragmentListBinding.bind(view)

        // recycle view
        var adapter = MahasiswaAdapter()
        var recyclerView = listBinding.listMahasiswa
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mahasiswaViewModel = ViewModelProvider(this).get(MahasiswaViewModel::class.java)

        // read data dari database
        mahasiswaViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            t -> adapter.setData(t)
        }
        )

        // pindah fragment
        listBinding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_list_to_add)
        }
        return view
    }

}