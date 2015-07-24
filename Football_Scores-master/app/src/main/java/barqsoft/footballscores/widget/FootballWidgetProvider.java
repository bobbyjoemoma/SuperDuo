package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;

/**
 * Created by TIM on 7/23/2015.
 */
public class FootballWidgetProvider extends AppWidgetProvider{

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){

        Log.v("widget", "update entered");
        for(int appWidgetId : appWidgetIds){
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_list);

            Intent adapterIntent = new Intent(context, FootballRemoteViewsService.class);
            views.setRemoteAdapter(R.id.widget_list,adapterIntent);


            Intent clickTemplateIntent = new Intent(context, MainActivity.class);
            //.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, clickTemplateIntent, 0);
            views.setPendingIntentTemplate(R.id.widget_list, pendingIntent);

            Log.v("widget", "update called");
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        //super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
