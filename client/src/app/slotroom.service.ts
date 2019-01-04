import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SlotroomService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/rest/slotroom');
  }

  get(id: string) {
    return this.http.get('//localhost:8080/rest/slotroom/'+id);
  }

  create(slotroom: any): Observable<any> {
    return this.http.post('//localhost:8080/rest/slotroom', slotroom);
  }

  update(slotroom: any): Observable<any> {
    return this.http.put('//localhost:8080/rest/slotroom', slotroom);
  }

  delete(id: string) {
    return this.http.delete('//localhost:8080/rest/slotroom/'+id);
  }
}
