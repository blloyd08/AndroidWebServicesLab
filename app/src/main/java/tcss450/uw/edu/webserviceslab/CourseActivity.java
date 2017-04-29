package tcss450.uw.edu.webserviceslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tcss450.uw.edu.webserviceslab.course.Course;

public class CourseActivity extends AppCompatActivity
implements CourseFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        if (savedInstanceState == null || getSupportFragmentManager().findFragmentById(R.id.list) == null) {
            CourseFragment courseFragment = new CourseFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, courseFragment)
                    .commit();
        }

    }

    @Override
    public void onListFragmentInteraction(Course course){

    }
}
