import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

import { Slotmachine } from '../slotmachine'
import { SlotmachineService } from '../slotmachine.service';
import { Slotroom } from '../slotroom'
import { SlotroomService } from '../slotroom.service';

@Component({
  selector: 'app-slotmachine-add',
  templateUrl: './slotmachine-add.component.html',
  styleUrls: ['./slotmachine-add.component.css']
})
export class SlotmachineAddComponent implements OnInit {
  slotmachine: Slotmachine = new Slotmachine();
  slotrooms: Slotroom[];

  constructor(
    private router: Router,
    private slotmachineService: SlotmachineService,
    private slotroomService: SlotroomService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getSlotrooms();
  }

  getSlotrooms(): void {
    this.slotroomService.getAll().subscribe(slotrooms => this.slotrooms = slotrooms);
  }

  goBack(): void {
    this.location.back();
  }

  save() {
    this.slotmachineService.create(this.slotmachine)
      .subscribe(data => console.log(data), error => console.log(error));
      this.slotmachine = new Slotmachine();
      this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/slotmachines']);
  }
}
