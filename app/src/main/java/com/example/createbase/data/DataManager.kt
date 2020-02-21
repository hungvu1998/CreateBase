package com.example.createbase.data

import com.example.createbase.data.local.db.DbHelper
import com.example.createbase.data.local.prefs.PreferencesHelper
import com.example.createbase.data.remote.ApiHelper
import io.reactivex.Observable

interface DataManager : DbHelper, PreferencesHelper, ApiHelper {


}
