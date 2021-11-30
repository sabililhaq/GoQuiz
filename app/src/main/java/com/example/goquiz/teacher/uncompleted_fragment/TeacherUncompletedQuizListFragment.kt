package com.example.goquiz.teacher.uncompleted_fragment

import com.example.goquiz.R
import com.example.goquiz.data.quiz.Quiz
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goquiz.data.quiz.Answer
import com.example.goquiz.data.quiz.Question
import com.example.goquiz.data.quiz.Response
import com.example.goquiz.data.quiz.ResponseAnswer
import com.example.goquiz.teacher.TeacherMainMenuActivity


class TeacherUncompletedQuizListFragment : Fragment(), TeacherUncompletedListQuizAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.teacher_fragment_uncompleted_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<Quiz>()

//        val quiz1 = Quiz(
//            teacher_uid = "hx4AafymSfduHRNw0vlCkL8uYD73",
//            description = "Kuis 1 Matematika Wajib",
//            start_time = "12/11/2021 08:00:00",
//            end_time = "12/03/2022 23:59:59",
//            questions = ArrayList<Question>(
//                Question(
//                    question = "Berapakah jumlah satu permen ditambah dengan satu permen?",
//                    answers = ArrayList<Answer>(
//                        Answer(answer = "Satu"),
//                        Answer(answer = "Dua"),
//                        Answer(answer = "Empat"),
//                        Answer(answer = "Jakarta Selatan")
//                    ),
//                    correct_answer = Answer(answer = "Dua")
//                )
//            ),
//            responses = ArrayList<Response>(
//                Response(
//                    student_uid = "spMiLlJh2FWpXtpXAhydGYW9Qu63",
//                    response_answer = ArrayList<ResponseAnswer>(
//                        ResponseAnswer()
//                    )
//                )
//            )
//
//        )

//        val hero1 = Hero(name="Ahmad Dahlan", description = "iai Haji Ahmad Dahlan atau Muhammad Darwis (bahasa Arab: أحمد دحلان\u200E; 1 Agustus 1868 – 23 Februari 1923) adalah seorang Pahlawan Nasional Indonesia yang merupakan pendiri Muhammadiyah. ",photo = R.drawable.ahmaddahlan)
//        val hero2 = Hero(name = "Hatta", description = "egarawan dan ekonom Indonesia yang menjabat sebagai Wakil Presiden Indonesia pertama.", photo = R.drawable.hatta)
//        val hero3 = Hero(name = "Soekarno",description = " Presiden pertama Republik Indonesia yang menjabat pada periode 1945–1967", photo = R.drawable.soekarno)
//        val hero4 = Hero(name = "Sutomo",description = "atau lebih dikenal dengan sapaan akrab Bung Tomo adalah pahlawan nasional Indonesia yang terkenal karena peranannya dalam Pertempuran 10 November 1945.", photo = R.drawable.sutomo)
//        val hero5 = Hero(name = "Diponegoro",description = "salah seorang pahlawan nasional Republik Indonesia, yang memimpin Perang Diponegoro atau Perang Jawa selama periode tahun 1825 hingga 1830 melawan pemerintah Hindia Belanda.", photo = R.drawable.diponegoro)

//        list.add(hero1)
//        list.add(hero2)
//        list.add(hero3)
//        list.add(hero4)
//        list.add(hero5)


        val rvHeroes: RecyclerView = view.findViewById(R.id.rv_heroes)
        val listHeroAdapter = TeacherUncompletedListQuizAdapter(list, this)
        rvHeroes.adapter = listHeroAdapter
        rvHeroes.layoutManager = LinearLayoutManager(requireContext())

//        childFragmentManager?.beginTransaction()
    }

    override fun onItemClicked(productModel: Quiz) {
        (activity as TeacherMainMenuActivity).navigateWithData(quiz = productModel)
    }
}