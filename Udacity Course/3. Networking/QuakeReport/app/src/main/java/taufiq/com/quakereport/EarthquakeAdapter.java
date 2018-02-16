package taufiq.com.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by taufiq on 15/02/18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = (Earthquake) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentEarthquake.getmMagnitude());

        //-------------------------------------------------------------

        String originalLocation = currentEarthquake.getmPlaceMagnitude();

        String primaryLocation;
        String locationOffset;

        // Check whether the originalLocation string contains the " of " text
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            // Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = "Near the";
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            primaryLocation = originalLocation;
        }


        // Find the TextView with view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Display the location of the current earthquake in that TextView
        primaryLocationView.setText(primaryLocation);

        // Find the TextView with view ID location offset
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Display the location offset of the current earthquake in that TextView
        locationOffsetView.setText(locationOffset);

        //----------------------------------------------------------
        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        String formattedDate = formatDate(dateObject);

        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
