package tcss450.uw.edu.webserviceslab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tcss450.uw.edu.webserviceslab.course.Course;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public final static String COURSE_ITEM_SELECTED = "course_selected";

    private TextView mCourseIdTextView;
    private TextView mCourseShortDescTextView;
    private TextView mCourseLongDescTextView;
    private TextView mCoursePrereqsTextView;


    public CourseDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseDetailFragment newInstance(String param1, String param2) {
        CourseDetailFragment fragment = new CourseDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_course_detail, container, false);
        mCourseIdTextView = (TextView) view.findViewById(R.id.course_item_id);
        mCourseShortDescTextView = (TextView) view.findViewById(R.id.course_short_desc);
        mCourseLongDescTextView = (TextView) view.findViewById(R.id.course_long_desc);
        mCoursePrereqsTextView = (TextView) view.findViewById(R.id.course_prereqs);

        return view;
    }

    public void updateView(Course course) {
        if (course != null) {
            mCourseIdTextView.setText(course.getCourseID());
            mCourseShortDescTextView.setText(course.getShortDescription());
            mCourseLongDescTextView.setText(course.getLongDescription());
            mCoursePrereqsTextView.setText(course.getPrereqs());
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateView((Course) args.getSerializable(COURSE_ITEM_SELECTED));
        }
    }



}
