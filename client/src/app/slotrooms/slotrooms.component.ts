import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Slotroom } from '../slotroom';
import { SlotroomService } from '../slotroom.service';

@Component({
  selector: 'app-slotrooms',
  templateUrl: './slotrooms.component.html',
  styleUrls: ['./slotrooms.component.css']
})
export class SlotroomsComponent implements OnInit, OnChanges {

  slotrooms: Slotroom[];
  displayedColumns: string[] = ['name', 'addres','edit' ,'delete'];


  constructor(
    private slotroomService: SlotroomService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit() {
    this.getSlotrooms();
  }

  ngOnChanges() {
    this.getSlotrooms();
  }
  getSlotrooms(): void {
    this.slotroomService.getAll().subscribe(slotrooms => this.slotrooms = slotrooms);
  }

  delete(id: string): void {
    this.slotroomService.delete(id).subscribe();
    this.slotrooms = this.slotrooms.filter(item => item.id != id);
  }
}
