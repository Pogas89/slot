import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Slotmachine } from '../slotmachine'
import { SlotmachineService } from '../slotmachine.service';
import { Slotroom } from '../slotroom'
import { SlotroomService } from '../slotroom.service';

@Component({
  selector: 'app-slotmachine-edit',
  templateUrl: './slotmachine-edit.component.html',
  styleUrls: ['./slotmachine-edit.component.css']
})
export class SlotmachineEditComponent implements OnInit {
  slotmachine: Slotmachine;
  slotrooms: Slotroom[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private slotmachineService: SlotmachineService,
    private slotroomService: SlotroomService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getSlotrooms();
    this.getSlotmachine();
  }

  getSlotmachine(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.slotmachineService.get(id)
    .subscribe((data: any) => this.slotmachine = data);
  }

  getSlotrooms(): void {
    this.slotroomService.getAll().subscribe(slotrooms => this.slotrooms = slotrooms);
  }

  goBack(): void {
    this.location.back();
  }

  save() {
    this.slotmachineService.update(this.slotmachine).subscribe();
      this.slotmachine = new Slotmachine();
      this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/slotmachines']);
  }
}
