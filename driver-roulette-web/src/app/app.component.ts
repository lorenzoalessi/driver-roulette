import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgForOf} from "@angular/common";
import {ConfigService} from "./config.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    NgForOf
  ],
  providers: [ConfigService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'driver-roulette';
  names: string[] = []

  constructor(private configService: ConfigService) {
  }

  ngOnInit() {
    this.configService.getNames()
      .subscribe(data => this.names = data);
  }
}
