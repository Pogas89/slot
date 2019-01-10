import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { SlotroomsComponent }      from './slotrooms/slotrooms.component';
import { SlotroomEditComponent }  from './slotroom-edit/slotroom-edit.component';
import { SlotroomAddComponent }  from './slotroom-add/slotroom-add.component';
import { SlotmachinesComponent } from './slotmachines/slotmachines.component';
import { SlotmachineEditComponent }  from './slotmachine-edit/slotmachine-edit.component';
import { SlotmachineAddComponent }  from './slotmachine-add/slotmachine-add.component';

 
const routes: Routes = [
  { path: '', redirectTo: '/slotrooms', pathMatch: 'full' },
  { path: 'slotroom-edit/:id', component: SlotroomEditComponent },
  { path: 'slotroom-add', component: SlotroomAddComponent },
  { path: 'slotrooms', component: SlotroomsComponent },
  { path: 'slotmachine-edit/:id', component: SlotmachineEditComponent },
  { path: 'slotmachine-add', component: SlotmachineAddComponent },
  { path: 'slotmachines', component: SlotmachinesComponent },
  { path: 'slotmachines/:slotroomId', component: SlotmachinesComponent }
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}