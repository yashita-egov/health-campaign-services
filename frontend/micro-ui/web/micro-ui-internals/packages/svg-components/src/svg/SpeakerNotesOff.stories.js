import React from "react";
import { SpeakerNotesOff } from "./SpeakerNotesOff";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "SpeakerNotesOff",
  component: SpeakerNotesOff,
};

export const Default = () => <SpeakerNotesOff />;
export const Fill = () => <SpeakerNotesOff fill="blue" />;
export const Size = () => <SpeakerNotesOff height="50" width="50" />;
export const CustomStyle = () => <SpeakerNotesOff style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <SpeakerNotesOff className="custom-class" />;
