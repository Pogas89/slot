import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
 
  constructor(
    private token: TokenStorageService,
    private location: Location
    ) { }
 
  ngOnInit() {
    this.token.signOut();
    this.location.go("auth/login");
    window.location.reload();
  }
}
