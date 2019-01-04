import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

import { Slotroom } from '../slotroom'
import { SlotroomService } from '../slotroom.service';

@Component({
  selector: 'app-slotroom-add',
  templateUrl: './slotroom-add.component.html',
  styleUrls: ['./slotroom-add.component.css']
})
export class SlotroomAddComponent implements OnInit {
  slotroom: Slotroom = new Slotroom();

  constructor(
    private router: Router,
    private slotroomService: SlotroomService,
    private location: Location
  ) { }

  ngOnInit() {
  }

  goBack(): void {
    this.location.back();
  }

  save() {
    this.slotroomService.create(this.slotroom)
      .subscribe(data => console.log(data), error => console.log(error));
      this.slotroom = new Slotroom();
      this.goBack();
  }
}
