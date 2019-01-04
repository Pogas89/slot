import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Slotroom } from '../slotroom'
import { SlotroomService } from '../slotroom.service';

@Component({
  selector: 'app-slotroom-edit',
  templateUrl: './slotroom-edit.component.html',
  styleUrls: ['./slotroom-edit.component.css']
})
export class SlotroomEditComponent implements OnInit {
  slotroom: Slotroom;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private slotroomService: SlotroomService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getSlotroom();
  }

  getSlotroom(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.slotroomService.get(id)
    .subscribe((data: any) => this.slotroom = data);
  }

  goBack(): void {
    this.location.back();
  }

  save() {
    this.slotroomService.update(this.slotroom).subscribe();
      this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/slotrooms']);
  }
}
