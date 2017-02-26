package gd.rf.gamov.blooddonationcollaborationsystem;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 192.168.3.5 on 2/26/2017.
 */

public class feedAdapter extends ArrayAdapter<UPosts> {
    public feedAdapter(Context context, int resource, List<UPosts> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.feedlist,parent,false);

        }

        TextView UName = (TextView)convertView.findViewById(R.id.UName);
        TextView UnitofBloods = (TextView)convertView.findViewById(R.id.UnitOfBloods);
        TextView HospitalandRelations = (TextView)convertView.findViewById(R.id.HospitalandRelation);
        TextView Time = (TextView)convertView.findViewById(R.id.Time);
        TextView Contact = (TextView)convertView.findViewById(R.id.Contact);
        TextView Addinfo = (TextView)convertView.findViewById(R.id.AddInfo);
        TextView Volunteer = (TextView)convertView.findViewById(R.id.Volunteer);
        TextView CurrentReq = (TextView)convertView.findViewById(R.id.CurrentReq);



        UPosts postz = getItem(position);

        UName.setText(postz.getName());
        UnitofBloods.setText(postz.getUnits() +" of "+postz.getBloodgroups()+"required");
        HospitalandRelations.setText("At "+postz.getHospital() +" for my "+postz.getRelation());
        Time.setText("Urgency "+postz.getUrgent());
        Contact.setText("Contact at : " + postz.getContact());
        Addinfo.setText(postz.getInstructions());
        Volunteer.setText("Volunteers Uptil Now : "+ "0");
        CurrentReq.setText("Current Required : "+ "0");



        return convertView;
    }


}