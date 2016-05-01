package com.jfilowk.elementstest.presentation.internal.exception;

import android.content.Context;
import com.jfilowk.elementstest.R;
import com.jfilowk.elementstest.data.exception.ItemException;
import com.jfilowk.elementstest.data.exception.NetworkConnectionException;

public class ErrorMessageFactory {
  public ErrorMessageFactory() {
  }

  public static String create(Context context, Exception exception) {
    String message = context.getString(R.string.something_broken);

    if (exception instanceof NetworkConnectionException) {
      message = context.getString(R.string.check_connectivity);
    } else if (exception instanceof ItemException) {
      message = context.getString(R.string.elements_server);
    }

    return message;
  }
}
