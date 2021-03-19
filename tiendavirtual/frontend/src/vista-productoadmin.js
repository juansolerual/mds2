import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaProductoadmin extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			margin: var(--lumo-space-m);
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;" id="vaadinHorizontalLayout"></vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-productoadmin';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductoadmin.is, VistaProductoadmin);
