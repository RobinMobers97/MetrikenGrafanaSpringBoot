import {BrowserModule} from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';

import {registerLocaleData} from '@angular/common';
import localeDe from '@angular/common/locales/de';

import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';


import {HttpClientModule} from '@angular/common/http';

import {BackendService} from './service/backend.service';

import { ScrollingModule } from '@angular/cdk/scrolling';


registerLocaleData(localeDe, 'de');

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ScrollingModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'de-DE'},
    BackendService
  ],
  entryComponents: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
