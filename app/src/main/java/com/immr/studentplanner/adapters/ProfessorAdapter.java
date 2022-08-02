package com.immr.studentplanner.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.immr.studentplanner.model.Professor;
import com.immr.studentplanner.R;

import java.util.ArrayList;

public class ProfessorAdapter extends ArrayAdapter<Professor> {

    public ProfessorAdapter(@NonNull Context context, ArrayList<Professor> professor) {
        super(context, R.layout.term_row, professor);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.professor_row, parent, false);

        Professor professor = getItem(position);
        TextView professorName = customView.findViewById(R.id.lvProfessorName);
        TextView professorPhone = customView.findViewById(R.id.lvProfessorPhone);
        TextView professorEmail = customView.findViewById(R.id.lvProfessorEmail);


        professorName.setText(professor.getProfessorName());
        professorPhone.setText(professor.getProfessorPhone());
        professorEmail.setText(professor.getProfessorEmail());

        return customView;
    }

}
