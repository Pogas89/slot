import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule, MatCheckboxModule, MatRadioModule, MatSelectModule } from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { SlotroomsComponent } from './slotrooms/slotrooms.component';
import { SlotroomEditComponent } from './slotroom-edit/slotroom-edit.component';

import { AppRoutingModule } from './app-routing.module';
import { SlotmachinesComponent } from './slotmachines/slotmachines.component';
import { SlotroomAddComponent } from './slotroom-add/slotroom-add.component';
import { SlotmachineAddComponent } from './slotmachine-add/slotmachine-add.component';
import { SlotmachineEditComponent } from './slotmachine-edit/slotmachine-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    SlotroomsComponent,
    SlotroomEditComponent,
    SlotmachinesComponent,
    SlotroomAddComponent,
    SlotmachineAddComponent,
    SlotmachineEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatButtonModule, 
    MatCardModule, 
    MatInputModule, 
    MatListModule, 
    MatToolbarModule,
    MatTableModule,
    MatCheckboxModule,
    MatRadioModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
