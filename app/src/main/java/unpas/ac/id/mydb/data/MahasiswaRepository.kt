package unpas.ac.id.mydb.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData

class MahasiswaRepository(private  val MahasiswaDao:MahasiswaDao) {
    val readAllData:LiveData<List<Mahasiswa>> = MahasiswaDao.readAllData()

    suspend fun addMahasiswa(mahasiswa: Mahasiswa){
        MahasiswaDao.addMahasiswa(mahasiswa)
    }
}