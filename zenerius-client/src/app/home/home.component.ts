import { Component, OnInit } from '@angular/core';
import { HomeService } from '../services/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  text: any;

  constructor(private homeService: HomeService) { }

  ngOnInit(): void {
      this.homeService.get().subscribe(data => {
        this.text = data;
        console.log("success");
      }, error => {
        this.text = error;
        console.log("error");
      })
  }

}
