package com.example.goquiz.teacher.uncompleted_fragment

import android.content.Intent
import com.example.goquiz.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goquiz.data.TempQuiz
import com.example.goquiz.student.StudentMainMenuActivity
import com.example.goquiz.teacher.TeacherMainMenuActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.teacher_fragment_uncompleted_quiz.*


class TeacherUncompletedQuizListFragment : Fragment()
    , TeacherUncompletedListQuizAdapter.OnItemClickListener
{
    // TODO: Rename and change types of parameters

    private lateinit var  auth: FirebaseAuth
    private lateinit var dbref: DatabaseReference
    private lateinit var quizRecyclerView : RecyclerView
    private lateinit var quizArrayList: ArrayList<TempQuiz>
    private lateinit var quizID: ArrayList<String>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.teacher_fragment_uncompleted_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        quizRecyclerView = rv_quizes
        quizRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        quizArrayList = arrayListOf<TempQuiz>()
        quizID = arrayListOf<String>()
        showQuiz()

//        val list = ArrayList<TempQuiz>()
//        val kuis1 = TempQuiz("hx4AafymSfduHRNw0vlCkL8uYD73", "Kuis Matematika Peminatan 1", "2022/02/02 08:00:00", "2022/02/03 23:59:59")
//        val kuis2 = TempQuiz("hx4AafymSfduHRNw0vlCkL8uYD73", "UTS Sejarah 1", "2021/11/30 10:00:00", "2022/02/02 23:59:59")
//        val kuis3 = TempQuiz("hx4AafymSfduHRNw0vlCkL8uYD73", "Remedial Matematika Wajib 2", "2022/02/02 08:00:00", "2022/02/02 23:59:59")
//        val kuis4 = TempQuiz("hx4AafymSfduHRNw0vlCkL8uYD73", "Ujian Akhir", "2022/02/02 08:00:00", "2022/02/02 23:59:59")
//        val kuis5 = TempQuiz("hx4AafymSfduHRNw0vlCkL8uYD73", "UAS Matematika Peminatan", "2022/02/02 08:00:00", "2022/02/02 23:59:59")
//        val kuis6 = TempQuiz("hx4AafymSfduHRNw0vlCkL8uYD73", "Remedial Sejarah 1", "2022/02/02 08:00:00", "2022/02/02 23:59:59")
//
//
//
//        list.add(kuis1)
//        list.add(kuis2)
//        list.add(kuis3)
//        list.add(kuis4)
//        list.add(kuis5)
//        list.add(kuis6)
//
//
//        val rvQuiz: RecyclerView = view.findViewById(R.id.rv_quizes)
//        val listQuizAdapter = TeacherUncompletedListQuizAdapter(list
//            , this
//        )
//        rvQuiz.adapter = listQuizAdapter
//        rvQuiz.layoutManager = LinearLayoutManager(requireContext())
//
//
//        childFragmentManager?.beginTransaction()
    }

    fun showQuiz(){
        dbref = FirebaseDatabase.getInstance().getReference("/tmp_quizess")

        dbref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (quizSnapshot in snapshot.children) {
                        if (quizSnapshot.child("teacher_uid").value == auth.uid){
                            val quiz = quizSnapshot.getValue(TempQuiz::class.java)
                            quizID.add(quizSnapshot.key.toString())
                            quizArrayList.add(quiz!!)
                        }else{
                            continue
                        }
                    }

                    quizRecyclerView.adapter = TeacherUncompletedListQuizAdapter(quizArrayList, this@TeacherUncompletedQuizListFragment, quizID)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                print("Ada error di data quiz")
            }

        })
    }

    override fun onItemClicked(productModel: TempQuiz, quizID: String) {
        (activity as TeacherMainMenuActivity).navigateWithData(kuis = productModel, quizID = quizID)
    }
}