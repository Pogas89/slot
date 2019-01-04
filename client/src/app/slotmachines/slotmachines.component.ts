import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Slotmachine } from '../slotmachine';
import { SlotmachineService } from '../slotmachine.service'

@Component({
  selector: 'app-slotmachines',
  templateUrl: './slotmachines.component.html',
  styleUrls: ['./slotmachines.component.css']
})
export class SlotmachinesComponent implements OnInit, OnChanges {

  slotmachines: Slotmachine[];
  displayedColumns: string[] = ['model', 'version', 'factoryNumber', 'techService', 'skksNumber', 'slotroomAddres','edit' ,'delete'];

  constructor(
    private slotmachineService: SlotmachineService,
    private route: ActivatedRoute,
    ) { }

  ngOnInit() {
    const slotroomId = this.route.snapshot.paramMap.get('slotroomId');
    if (slotroomId!=null){
      this.getSlotmachinesInSlotroom(slotroomId);
    } else {
      this.getSlotmachines();
    }
  }

  ngOnChanges() {
    const slotroomId = this.route.snapshot.paramMap.get('slotroomId');
    if (slotroomId!=null){
      this.getSlotmachinesInSlotroom(slotroomId);
    } else {
      this.getSlotmachines();
    }
  }

  getSlotmachines(): void {
    this.slotmachineService.getAll().subscribe(slotmachines => this.slotmachines = slotmachines)
  }

  getSlotmachinesInSlotroom(slotroomId: string): void {
    this.slotmachineService.getBySlotroomId(slotroomId).subscribe(slotmachines => this.slotmachines = slotmachines)
  }

  delete(id: string): void {
    this.slotmachineService.delete(id).subscribe();
    this.slotmachines = this.slotmachines.filter(item => item.id != id);
  }
}
