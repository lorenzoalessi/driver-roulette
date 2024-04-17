import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {ConfigService} from "./config.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    NgForOf,
    NgClass,
    NgIf
  ],
  providers: [ConfigService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'driver-roulette';
  names: string[] = []
  cardColors: boolean[] = []
  requestNames: string[] = []
  result: string = ""

  constructor(private configService: ConfigService) {
  }

  ngOnInit() {
    this.configService.getNames()
      .subscribe(data => this.names = data);
  }

  toggleCardColor(index: number) {
    this.cardColors[index] = !this.cardColors[index];
  }

  roulette() {
    this.requestNames = [];
    for (let i = 0; i < this.names.length; i++) {
      if (!this.cardColors[i]) {
        this.requestNames.push(this.names[i]);
      }
    }

    if (this.requestNames.length == 0)
      alert("Includere almeno un guidatore!")

    this.configService.roulette(this.requestNames)
      .subscribe(data => this.result = data);
  }
}
